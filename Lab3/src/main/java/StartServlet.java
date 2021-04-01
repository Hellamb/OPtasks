import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

@WebServlet(urlPatterns = "")
public class StartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> params = request.getParameterMap();

        if (!params.isEmpty())
        {
            if (    !params.containsKey("a")
                    || !params.containsKey("b")
                    || !params.containsKey("c")
                    || !params.containsKey("d")
                    || !params.containsKey("equation"))
            {
                //Bad Request
                response.sendError(400);
                return;
            }

            String aParam = params.get("a")[0];
            String bParam = params.get("b")[0];
            String cParam = params.get("c")[0];
            String dParam = params.get("d")[0];
            String equation = params.get("equation")[0];
            double result;

            try
            {
                 result = Equations.parseParams(aParam,bParam,cParam,dParam,equation);
            }catch (IllegalArgumentException e)
            {
                response.sendError(400, e.getMessage());
                return;
            }


            //Cookies
            Cookie[] eqData = new Cookie[5];

            eqData[0] = new Cookie("parameterA", aParam);
            eqData[1] = new Cookie("parameterB", bParam);
            eqData[2] = new Cookie("parameterC", bParam);
            eqData[3] = new Cookie("parameterD", bParam);
            eqData[4] = new Cookie("nEquation", equation);

            for (Cookie eqDatum : eqData) {
                //2 Days
                eqDatum.setMaxAge(172800);

                response.addCookie(eqDatum);
            }


            //Work with session
            HttpSession session = request.getSession();

            ArrayList<Map<String, String>> ps = (ArrayList<Map<String, String>>) session.getAttribute("parameters");
            Map<String, String> eqSesData = Map.of("a", aParam,
                    "b", bParam,
                    "c", cParam,
                    "d", dParam,
                    "equation", equation,
                    "result", String.valueOf(result));

            if (ps != null)
                ps.add(eqSesData);
            else
            {
                ArrayList<Map<String, String>> sesParams = new ArrayList<>();

                sesParams.add(eqSesData);

                session.setAttribute("parameters", sesParams);
            }
        }

        getServletContext().getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
    }
}
