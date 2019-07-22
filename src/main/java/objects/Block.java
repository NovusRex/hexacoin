package objects;

import java.sql.Timestamp;

public class Block {

    public long index;
    public Transactions trans;
    public long nonce;
    public String prev_hash;

    public Block(long index, Transactions trans, long nonce, String prev_hash){
        this.index = index;
        this.trans = trans;
        this.nonce = nonce;
        this.prev_hash = prev_hash;
    }

}
