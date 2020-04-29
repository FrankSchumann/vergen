package gradle_prototype;

import org.junit.Test;
import static org.junit.Assert.*;

public class MainAppTest {

   @Test
   public void testSayHello() {
      MainApp app = new MainApp();
      assertNotNull("Success", app.sayHello());
   }
}