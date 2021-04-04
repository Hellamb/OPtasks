import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

@WebServlet(urlPatterns = "")
public class StartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

            double result;
            Equations equations;

            try
            {
                equations = new Equations(params);
                result = equations.calc();
            }catch (IllegalArgumentException e)
            {
                response.sendError(400, e.getMessage());
                return;
            }


            //Cookies
            Cookie[] eqData = new Cookie[5];

            eqData[0] = new Cookie("parameterA", request.getParameter("a"));
            eqData[1] = new Cookie("parameterB", request.getParameter("b"));
            eqData[2] = new Cookie("parameterC", request.getParameter("c"));
            eqData[3] = new Cookie("parameterD", request.getParameter("d"));
            eqData[4] = new Cookie("nEquation", request.getParameter("equation"));

            for (Cookie eqDatum : eqData) {
                //2 Days
                eqDatum.setMaxAge(172800);

                response.addCookie(eqDatum);
            }


            //Work with session
            HttpSession session = request.getSession();

            ArrayList<Map<String, String>> ps = (ArrayList<Map<String, String>>) session.getAttribute("parameters");
            Map<String, String> eqSesData = Map.of( "a", request.getParameter("a"),
                                                    "b", request.getParameter("b"),
                                                    "c", request.getParameter("c"),
                                                    "d", request.getParameter("d"),
                                                    "equation", request.getParameter("equation"),
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}

