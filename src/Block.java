import java.util.Date;

public class Block {
	/**
	 * Id of the block
	 */
    private String hash;
    
    /**
     * Id of the previous block
     */
    private String previousHash;
    
    /**
     * Data in the block
     */
    private String data;
    
    /**
     * Timestamp of creation of the block
     */
    private long timeStamp;
    
    /**
     * Variable to find the valid hash on mine
     */
    private int nonce;
  
    /**
     * A basic Block tu use in a Blockchain class. Implement
     * the method mineBlock to find a valid hash to add the
     * block to the blockchain.
     * <p>
     * Maybe should pass that method to another Node class
     * for more explicite understanding of the subject.
     * </p>
     * @param data
     * @param previousHash
     */
    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.nonce = 0;
        this.hash = calculateBlockHash();
    }
    
    /**
     * A basic Block tu use in a Blockchain class. Implement
     * the method mineBlock to find a valid hash to add the
     * block to the blockchain.
     * <p>
     * Recives the timestamp too to
     * generate an instance of an old block.
     * </p>
     * <p>
     * Maybe should pass that method to another Node class
     * for more explicite understanding of the subject.
     * </p>
     * @param data
     * @param previousHash
     * @param timeStamp
     */
    public Block(String data, String previousHash, long timeStamp) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = timeStamp;
        this.nonce = 0;
        this.hash = calculateBlockHash();
    }
    
    /**
     * This constructor is only used on the very beginning
     * of the blockchain as root.
     * <p>
     * A basic Block tu use in a Blockchain class. Implement
     * the method mineBlock to find a valid hash to add the
     * block to the blockchain.
     * </p>
     * <p>
     * Maybe should pass that method to another Node class
     * for more explicite understanding of the subject.
     * </p>
     */
    public Block() {
        this.data = null;
        this.previousHash = null;
        this.timeStamp = 0l;
        this.nonce = 0;
        this.hash = null;
    }
    
    /**
     * Generate a hash using the attributes of the instance
     * @return A hash
     */
    public String calculateBlockHash() {
        String dataToHash = previousHash == null ? "" : previousHash;
        dataToHash += Long.toString(timeStamp)
        		+ data
        		+ Integer.toString(nonce);
        
        return Util.getSHA256(dataToHash);
    }
    
    /**
     * Search for a hash for the current isntance of the
     * Block valid for a specific blockchain
     * @param difficulty of the blockchain
     * @return A valid hash
     */
    public String mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0');
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateBlockHash();
        }
        return hash;
    }
    
	/**
	 * @return the hash
	 */
	public String getHash() {
		return hash;
	}

	/**
	 * @param hash the hash to set
	 */
	public void setHash(String hash) {
		this.hash = hash;
	}

	/**
	 * @return the previousHash
	 */
	public String getPreviousHash() {
		return previousHash;
	}

	/**
	 * @param previousHash the previousHash to set
	 */
	public void setPreviousHash(String previousHash) {
		this.previousHash = previousHash;
	}

	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * @return the timeStamp
	 */
	public long getTimeStamp() {
		return timeStamp;
	}

	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	/**
	 * @return the nonce
	 */
	public int getNonce() {
		return nonce;
	}

	/**
	 * @param nonce the nonce to set
	 */
	public void setNonce(int nonce) {
		this.nonce = nonce;
	}

	@Override
	public String toString() {
		return hash + " >> " + previousHash + " - " + data + " - " + Long.toString(timeStamp) + " - " + Integer.toString(nonce); 
	}
}