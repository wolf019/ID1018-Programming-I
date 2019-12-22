package EA3;
import java.util.Random;

public class ReachableFieldsOnChessboard {

	public static void main(String[] args) throws Chessboard.Chesspiece.NotValidFieldException {
	int w = 0; 
		Random rand = new Random();
		Chessboard chessBoard = new Chessboard (); 
		System.out.println (chessBoard + "\n");
		
		Chessboard.Chesspiece[] pieces = new Chessboard.Chesspiece[6]; 
        pieces[0] = chessBoard.new Pawn ('w', 'P');
        pieces[1] = chessBoard.new Rook ('b', 'R');
        pieces[2] = chessBoard.new Queen ('w', 'Q');
        pieces[3] = chessBoard.new Bishop ('w', 'B');
        pieces[4] = chessBoard.new King ('b', 'K');
        pieces[5] = chessBoard.new Knight ('w', 'N');
		
		System.out.println(" Piece 1 = White Pawn \n Piece 2 = Black Rook \n Piece 3 = White Queen \n "
				+ "Piece 4 = White Bishop \n Piece 5 = Black King \n Piece 6 = White Knight \n\n\n"
				+ "------------------------------------");
		
	while(w < 5) {
		int piece	= rand.nextInt(5);
		char fldChr = (char)(97 + rand.nextInt(7));
		byte fldNbr = (byte)(1 + rand.nextInt(7));
      
        pieces[piece].moveTo(fldChr, fldNbr);
        pieces[piece].markReachableFields();
        try
        {Thread.sleep(1000);}
        catch(InterruptedException ex)
        {Thread.currentThread().interrupt();}
        System.out.print(chessBoard);
        
        pieces[piece].unmarkReachableFields();
        
        try
        {Thread.sleep(1000);}
        catch(InterruptedException ex)
        {Thread.currentThread().interrupt();}
        System.out.print(chessBoard);
        
        pieces[piece].moveOut();
        
        try
        {Thread.sleep(1000);}
        catch(InterruptedException ex)
        {Thread.currentThread().interrupt();}
        System.out.print(chessBoard);
        
        w++;
        
		}
		
	}

}
