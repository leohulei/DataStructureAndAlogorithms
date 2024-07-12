package src.main.java.classical;

/**
 *用字符串数组作为井字游戏的游戏板 board，判断该游戏板有没有可能最终形成
 * 游戏板是一个 3 x 3 数组，由字符 " "，"X" 和 "O" 组成。字符 " " 代表一个空位。
 * 两个玩家轮流将字符放入空位，一个玩家执X棋，另一个玩家执O棋
 * “X” 和 “O” 只允许放置在空位中，不允许对已放有字符的位置进行填充。
 * 当有 3 个相同（且非空）的字符填充任何行、列或对角线时，游戏结束，board生成
 */
public class Board {
    public static void main(String[] args) {
//        String [] board = new String[]{"XXX","OXO","O O"};//false
        String [] board = new String[]{"XXX"," XO","O O"};//true
        System.out.println(board(board));
    }
    
    
    static boolean board(String[] board){
        int xCount = 0;
        int oCount = 0;//对x、o计数
        
        //如果X赢 xcount-ocount=1
        //如果0赢 xcount-ocount=0
        //胜负未分 上述两种都有可能
        for (String row: board) {
            for (char c: row.toCharArray()) {
                if (c == 'X'){
                    xCount++;
                }
                if (c == 'O'){
                    oCount++;
                }

            }
        }
        if (xCount != oCount && xCount - oCount !=1) {
            return false;
        }

        if (win(board,"XXX") && xCount - oCount !=1){
            return false;
        }
        if (win(board,"OOO") && xCount != oCount){
            return false;
        }
        
        return true;
    }

    static boolean win(String[] board,String flag){
        for (int i = 0; i < 3; i++) {
            //横向三连
            if (flag.equals(board[i])){
                return true;
            }
            //纵向三连
            if(flag.equals(""+board[0].charAt(i)+board[1].charAt(i)+board[2].charAt(i))){
                return true;
            }

        }
        // /向三连
        if (flag.equals(""+board[0].charAt(2)+board[1].charAt(1)+board[2].charAt(0))){
            return true;
        }
        // \向三连
        if (flag.equals(""+board[0].charAt(0)+board[1].charAt(1)+board[2].charAt(2))){
            return true;
        }
        return false;
    }
}
