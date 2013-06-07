package daoo.encoder;

import daoo.ioc.MessageEncoderTest;
import org.jetbrains.annotations.NotNull;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: laura
 * Date: 24/05/13
 * Time: 11:38
 * To change this template use File | Settings | File Templates.
 */
public class PlainEncoderTest extends MessageEncoderTest{
        public PlainEncoderTest(@NotNull java.lang.String message, @NotNull byte[] encodedMessage) {
            super(new PlainEncoder(), message, encodedMessage);
        }


        @Parameterized.Parameters
        public static Collection messages() {
            return Arrays.asList(new Object[][]{
                    {"mensaje", "mensaje".getBytes()},
                    {"84848", "84848".getBytes()},
                    {"toTo3", "toTo3".getBytes()},
            });
        }
}