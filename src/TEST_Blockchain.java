public class TEST_Blockchain {
	
	public static void main(String[] args) {		
		genWrong();
		
		genGood();
	}
	
	public static void genWrong() {
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
		
		//System.out.println(blockchain.validateBlock(blockchain.get("0000941f6ff34158d71309c93e7a34be0a910cebd6de2cbc23c621429edc3d9c")));
		System.out.println(blockchain.validateBlockchain());
		
		blockchain.printBlocks();
	}
	
	public static void genGood() {
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

		//System.out.println(blockchain.validateBlock(blockchain.get("0000941f6ff34158d71309c93e7a34be0a910cebd6de2cbc23c621429edc3d9c")));
		System.out.println(blockchain.validateBlockchain());
		
		blockchain.printBlocks();
	}
}
