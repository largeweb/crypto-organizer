package hacknc2021;
import java.io.IOException;

import org.python.util.PythonInterpreter;

public class jythonTest {
    public static void main(String[] args) throws IOException{
        PythonInterpreter pyInterp = new PythonInterpreter();
        pyInterp.exec("print('Hello Python World!')");
        Runtime.getRuntime().exec("python3 ai.py");
      }
}
