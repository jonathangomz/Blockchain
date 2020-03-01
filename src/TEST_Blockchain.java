public class TEST_Blockchain {
	
	static private Blockchain goodBlockchain;
	static private Blockchain badBlockchain;
	
	static {
		goodBlockchain = genGood();
		badBlockchain = genWrong();
	}
	
	public static void main(String[] args) {		
		
		// Test good blockchain
		System.out.println(goodBlockchain.validateBlock(goodBlockchain.getBlock("00002f2e93b80b310713d790b96839f8ad3892e6790568182926db9913764c61")));
		System.out.println(goodBlockchain.validateBlockchain());
		
		goodBlockchain.printBlocks();
		
		// Test bad blockchain
		System.out.println(badBlockchain.validateBlock(badBlockchain.getBlock("00002f2e93b80b310713d790b96839f8ad3892e6790568182926db9913764c61")));
		System.out.println(badBlockchain.validateBlockchain());
		
		badBlockchain.printBlocks();		
	}
	
	public static Blockchain genWrong() {
		Blockchain blockchain = new Blockchain(4);
		
		Block newBlock = new Block(
			      "First Block", 
			      blockchain.getLatestBlock().getHash(),
			      1582671613105l);
		newBlock.mineBlock(blockchain.difficulty);
		blockchain.addBlock(newBlock);
		
		newBlock = new Block(
			      "Second Block", 
			      blockchain.getLatestBlock().getHash(),
			      1582671613639l);
		newBlock.mineBlock(blockchain.difficulty);
		blockchain.addBlock(newBlock);
		blockchain.getBlock(newBlock.getHash()).setData("2 Block");
		
		newBlock = new Block(
			      "Third Block", 
			      blockchain.getLatestBlock().getHash(),
			      1582671613724l);
		newBlock.mineBlock(blockchain.difficulty);
		blockchain.addBlock(newBlock);
		blockchain.getBlock(newBlock.getHash()).setNonce(58593);
		
		newBlock = new Block(
			      "4Block", 
			      blockchain.getLatestBlock().getHash(),
			      1582671614514l);
		newBlock.mineBlock(blockchain.difficulty);
		blockchain.addBlock(newBlock);
		
		return blockchain;
	}
	
	public static Blockchain genGood() {
		Blockchain blockchain = new Blockchain(4);
		
		Block newBlock = new Block(
			      "First Block", 
			      blockchain.getLatestBlock().getHash(),
			      1582671613105l);
		newBlock.mineBlock(blockchain.difficulty);
		blockchain.addBlock(newBlock);

		newBlock = new Block(
			      "Second Block", 
			      blockchain.getLatestBlock().getHash(),
			      1582671613639l);
		newBlock.mineBlock(blockchain.difficulty);
		blockchain.addBlock(newBlock);

		newBlock = new Block(
			      "Third Block", 
			      blockchain.getLatestBlock().getHash(),
			      1582671613724l);
		newBlock.mineBlock(blockchain.difficulty);
		blockchain.addBlock(newBlock);

		newBlock = new Block(
			      "4Block", 
			      blockchain.getLatestBlock().getHash(),
			      1582671614514l);
		newBlock.mineBlock(blockchain.difficulty);
		blockchain.addBlock(newBlock);

		return blockchain;
	}
}
