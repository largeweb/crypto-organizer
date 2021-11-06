import org.python.util.PythonInterpreter;

public class jythonTest {
    public static void main(String[] args) {
        PythonInterpreter pyInterp = new PythonInterpreter();
        pyInterp.exec("print('Hello Python World!')");
      }
}
