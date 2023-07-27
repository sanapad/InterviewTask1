import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class MainTest {
    static String fileName = Main.FILE_NAME;

    @Test
    public void createFileShouldReturnFile() {
        Assert.assertEquals(Main.createFile(fileName).getClass(), File.class);
    }
}
