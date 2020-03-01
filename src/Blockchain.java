import java.util.LinkedHashMap;
import java.util.Map;

public class Blockchain {
	/**
	 * Blockchain
	 */
	private Map<String, Block> blockchain;
	
	/**
	 * Rule to mine the blocks
	 */
	public int difficulty;
	
	/**
	 * Prefix of the hash to be valid
	 */
	private String prefixString;
	
	/**
	 * 
	 * Class that implement the methods of a very basic blockchain using
	 * the class Block. Use a private LinkedHashMap to store the blocks.
	 * @param difficulty to mine blocks
	 */
	public Blockchain(int difficulty) {
		this.blockchain = new LinkedHashMap<>();
		this.difficulty = difficulty;
		this.prefixString = new String(new char[difficulty]).replace('\0', '0');
	}
	
	/**
	 * Get the first block in the blockchain
	 * @return The first Block
	 */
	public Block getFirstBlock() {
		Block firstBlock = null;
		for(Block block: blockchain.values()) {
			firstBlock = block; break;
		}
		return firstBlock == null? new Block() : firstBlock;
	}
	
	/**
	 * Get the latest block in the blockchain
	 * @return The last Block
	 */
	public Block getLatestBlock() {
		Block latestBlock = null;
		for(Block block: blockchain.values())
			latestBlock = block;
		return latestBlock == null? new Block() : latestBlock;
	}
	
	/**
	 * Get an specific block on the blockchain
	 * @param hash of the block
	 * @return the block itself
	 */
	public Block getBlock(String hash) {
		return blockchain.getOrDefault(hash, null);
	}
	
	/**
	 * Add a new block only if it it's valid according to the blockchain.
	 * @param block
	 * @return true if the block is added, false otherwise
	 */
	public boolean addBlock(Block block) {
		if(validateBlock(block)) {
			blockchain.put(block.getHash(), block);
			//System.out.println("The new Block was saved. INFO>> " + block.toString());
			return true;
		}
		//System.out.println("The new Block was not saved. INFO>> " + block.toString());
		return false;
	}
	
	/**
	 * Validate the given block according to the blockchain
	 * @param block
	 * @return true if the block is valid, false otherwise
	 */
	public boolean validateBlock(Block block) {
		return block != null && block.calculateBlockHash().equals(block.getHash())
				&& block.getHash().substring(0, difficulty).equals(prefixString);
	}
	
	/**
	 * Verify the validity of the blocks in the blockchain. Use recursion
	 * to iterate over all the blocks in the chain.
	 * @param block The current block to verify
	 * @return true for all the valid blocks, false otherwise
	 */
	private boolean validateChain(Block block) {
		if(block == null) return true;
		
		if(validateBlock(block))
			return validateChain(blockchain.getOrDefault(block.getPreviousHash(), null));
			
		return false;
	}
	
	/**
	 * Validate the blockchain itself starting from the last block added.
	 * @return true if the blockchain is valid, false otherwise
	 */
	public boolean validateBlockchain() {
		return validateChain(getLatestBlock());
	}
	
	/**
	 * Display all the blocks in the blockchain starting from the first block added
	 */
	public void printBlocks() {
		for(Block block: blockchain.values()) {
			System.out.println(block.toString());
		}
		System.out.println();
	}
}
