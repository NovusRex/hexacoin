import objects.Block;
import objects.Transactions;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestBlock {

    private Block block;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

    @Before
    public void setUp() {
        block = new Block(1, new Transactions(), Long.valueOf(sdf.format(new Timestamp(new Date().getTime()) )), null);
    }

    @Test
    public void testBlockCreationGenesis() {
        assertTrue(block.index == 1);
    }

    @Test
    public void testSecndBlock(){

    }
}
