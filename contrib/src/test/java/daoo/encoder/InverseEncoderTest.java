package daoo.encoder;


import daoo.ioc.MessageEncoder;
import org.jetbrains.annotations.NotNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import daoo.ioc.MessageEncoderTest;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: keevstessens
 * Date: 17/05/13
 * Time: 17:57
 * To change this template use File | Settings | File Templates.
 */

public class InverseEncoderTest extends MessageEncoderTest {

    public InverseEncoderTest(@NotNull java.lang.String message, @NotNull byte[] encodedMessage) {
        super(new InvertEncoder(), message, encodedMessage);
    }


    @Parameterized.Parameters
    public static Collection messages() {
        return Arrays.asList(new Object[][]{
                {"mensaje", "ejasnem".getBytes()},
                {"84848", "84848".getBytes()},
                {"toTo3", "3oTot".getBytes()},
        });
    }
}
