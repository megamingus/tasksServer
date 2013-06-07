package daoo.encoder;

import daoo.ioc.MessageEncoderTest;
import org.jetbrains.annotations.NotNull;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: Mingus
 * Date: 07/06/13
 * Time: 04:27
 * To change this template use File | Settings | File Templates.
 */
public class CypherEncoderTest extends MessageEncoderTest{
    public CypherEncoderTest(@NotNull java.lang.String message, @NotNull byte[] encodedMessage) {
        super(new CypherEncoder(), message, encodedMessage);
    }


    @Parameterized.Parameters
    public static Collection messages() {
        return Arrays.asList(new Object[][]{
                {"mensaje","".getBytes() },
        });
    }
}
