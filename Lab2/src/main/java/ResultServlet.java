import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(urlPatterns = "/result")
public class ResultServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> params = request.getParameterMap();

        if (!params.containsKey("a") || !params.containsKey("b") || !params.containsKey("c") || !params.containsKey("d") || !params.containsKey("equation"))
        {
            //Bad Request
            response.sendError(400);
            return;
        }

        try
        {
            switch (params.get("equation")[0])
            {
                case "1":
                    request.setAttribute("result", Equations.template1(Double.parseDouble(params.get("a")[0]),
                            Double.parseDouble(params.get("b")[0]),
                            Double.parseDouble(params.get("c")[0]),
                            Double.parseDouble(params.get("d")[0])));
                    break;

                case "2":
                    request.setAttribute("result", Equations.template2(Double.parseDouble(params.get("a")[0]),
                            Double.parseDouble(params.get("b")[0]),
                            Double.parseDouble(params.get("c")[0]),
                            Double.parseDouble(params.get("d")[0])));
                    break;

                case "3":
                    request.setAttribute("result", Equations.template3(Double.parseDouble(params.get("a")[0]),
                            Double.parseDouble(params.get("b")[0]),
                            Double.parseDouble(params.get("c")[0]),
                            Double.parseDouble(params.get("d")[0])));
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

        //Work with Cookies
        Cookie[] eqData = new Cookie[5];

        eqData[0] = new Cookie("parameterA", params.get("a")[0]);
        eqData[1] = new Cookie("parameterB", params.get("b")[0]);
        eqData[2] = new Cookie("parameterC", params.get("c")[0]);
        eqData[3] = new Cookie("parameterD", params.get("d")[0]);
        eqData[4] = new Cookie("nEquation", params.get("equation")[0]);

        for (int i = 0; i < eqData.length; i++)
        {
            //2 Days
            eqData[i].setMaxAge(172800);

            response.addCookie(eqData[i]);
        }

        //Get View
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/solution.jsp").forward(request, response);
    }
}
