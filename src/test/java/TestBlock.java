import TempSafe.RedisSafe;
import com.google.common.hash.Hashing;
import objects.Block;
import objects.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestBlock {

    private Block block;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    RedisSafe redis;

    @Before
    public void setUp() {
        redis = new RedisSafe();
        redis.jedis.flushAll();
        block = new Block(1, new ArrayList<Transaction>(), Long.valueOf(sdf.format(new Timestamp(new Date().getTime()) )), null);
        redis.jedis.append("Block "+block.index, block.toString());
    }

    @Test
    public void testBlockCreationGenesis() {
        System.out.println("testfirstBlock");
        assertTrue(block.index == 1);
        assertEquals("IsGenesisBlock", block.prev_hash == null ? "IsGenesisBlock": "IsNotGenesis");
    }

    @Test
    public void testSecndBlock(){
        System.out.println("testSecndBlock");
        String block1 = redis.jedis.get("Block 1");
        String hashOfBlock = Hashing.sha256().hashString(block1, StandardCharsets.UTF_8).toString();
        block = new Block(2, new ArrayList<Transaction>(), Long.valueOf(sdf.format(new Timestamp(new Date().getTime()) )), hashOfBlock);

        assertTrue(block.index > 1);
        assertEquals("IsNotGenesis", block.prev_hash == null ? "IsGenesisBlock": "IsNotGenesis");
        redis.jedis.append("Block "+block.index, block.toString());
        System.out.println(redis.jedis.get("Block "+1));
        System.out.println(redis.jedis.get("Block "+block.index));

    }
}
