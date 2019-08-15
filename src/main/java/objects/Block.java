package objects;

import java.util.Arrays;
import java.util.List;

public class Block {

    public long index;
    public List<Transaction> trans;
    public long nonce;
    public String prev_hash;

    public Block(long index, List<Transaction> trans, long nonce, String prev_hash){
        this.index = index;
        this.trans = trans;
        this.nonce = nonce;
        this.prev_hash = prev_hash;
    }

    @Override
    public String toString(){
        return
                this.index + "; " +
                        Arrays.toString(this.trans.toArray())+"; " +
        this.nonce+"; " +
        this.prev_hash;



    }

}
