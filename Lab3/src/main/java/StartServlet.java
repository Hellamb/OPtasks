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
            if (!params.containsKey("a") || !params.containsKey("b") || !params.containsKey("c") || !params.containsKey("d") || !params.containsKey("equation"))
            {
                //Bad Request
                response.sendError(400);
                return;
            }

            double result;

            try
            {
                double a = Double.parseDouble(params.get("a")[0]);
                double b = Double.parseDouble(params.get("b")[0]);
                double c = Double.parseDouble(params.get("c")[0]);
                double d = Double.parseDouble(params.get("d")[0]);

                switch (params.get("equation")[0])
                {
                    case "1":
                         result = Equations.template1(a, b, c, d);
                        break;

                    case "2":
                         result = Equations.template2(a, b, c, d);
                        break;

                    case "3":
                         result = Equations.template3(a, b, c, d);
                        break;

                    default:
                        response.sendError(400, "Wrong equation");
                        return;
                }
            }
            catch (NumberFormatException e)
            {
                //Bad request
                response.sendError(400);
                return;
            }

            //Cookies
            Cookie[] eqData = new Cookie[5];

            eqData[0] = new Cookie("parameterA", params.get("a")[0]);
            eqData[1] = new Cookie("parameterB", params.get("b")[0]);
            eqData[2] = new Cookie("parameterC", params.get("c")[0]);
            eqData[3] = new Cookie("parameterD", params.get("d")[0]);
            eqData[4] = new Cookie("nEquation", params.get("equation")[0]);

            for (Cookie eqDatum : eqData) {
                //2 Days
                eqDatum.setMaxAge(172800);

                response.addCookie(eqDatum);
            }


            //Work with session
            HttpSession session = request.getSession();

            ArrayList<Map<String, String>> ps = (ArrayList<Map<String, String>>) session.getAttribute("parameters");
            Map<String, String> eqSesData = Map.of("a", params.get("a")[0],
                    "b", params.get("b")[0],
                    "c", params.get("c")[0],
                    "d", params.get("d")[0],
                    "equation", params.get("equation")[0],
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
