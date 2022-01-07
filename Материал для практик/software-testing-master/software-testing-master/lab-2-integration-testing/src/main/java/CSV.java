import functions.Function;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class CSV {

    public void writeFuncToCsv(Function function, double start, double finish, double step) throws IOException {
        File file = new File("src/main/resources/" + function + ".csv");

        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();

        PrintWriter writer = new PrintWriter(file);

        writer.write("x;f(x)\n");


        for (double x = start; x <= finish; x += step) {
            String funcRes;

            try {
                double f = function.calculateFunction(x);
                funcRes = String.format("%.7f", f);
            } catch (IllegalArgumentException e) {
                funcRes = "null";
            }

            writer.write(String.format("%.5f", x) + ";" + funcRes + "\n");
        }

        writer.close();

    }

}
