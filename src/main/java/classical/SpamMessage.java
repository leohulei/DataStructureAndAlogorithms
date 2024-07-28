package src.main.java.classical;

import java.util.*;

public class SpamMessage {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            String input = sc.nextLine();
//            int count = Integer.parseInt( input );
//
//            String[] inputs = new String[count];
//            for( int i = 0; i < count; i ++ )
//            {
//                input = sc.nextLine();
//                inputs[i] = input;
//            }
//
//
//            String idA = sc.nextLine();
//            processMsgSpam( idA, inputs );
//        }
        String[] inputs = new String[15];
        String idA = "1";
        inputs[0] ="1 2";
        inputs[1] ="1 3";
        inputs[2] ="1 4";
        inputs[3] ="1 5";
        inputs[4] ="1 6";
        inputs[5] ="1 7";
        inputs[6] ="1 8";
        inputs[7] ="1 9";
        inputs[8] ="1 10";
        inputs[9] ="1 11";
        inputs[10] ="1 12";
        inputs[11] ="1 13";
        inputs[12] ="1 14";
        inputs[13] ="14 1";
        inputs[14] ="1 15";
         processMsgSpam(idA, inputs);


    }

    private static void processMsgSpam( String idA, String inputs[] )
    {
        Set<String> receivers = new HashSet<String>();//记录 idA 这个短信发送者发送短信的所有接收者 id
        Set<String> senders = new HashSet<String>();//记录所有给 idA 发送短信的用户 id
        int aSendCnt = 0;//初始值为 0。记录 idA 发送的短信条数
        int aReceiveCnt = 0;//初始值为 0。记录  idA 接收的短信条数
        //记录 idA 发送给其他用户，和其他用户发送给 idA 的短信条数。
        // 其中 key 的格式为 idA + " " +“其他用户id” （代表 idA 给其他用户发短信），
        // 或 “其他用户id” + " " + idA（代表其他用户给 idA 发短信），值为整型数字，表示短信条数。
        Map<String, Integer> msgSendCntMap = new HashMap<String, Integer>();

        for( int i = 0; i < inputs.length; i ++ )
        {
            String inputEle = inputs[i];
            String[] inputEleSplits = inputEle.split( " " );

            if( ( !inputEleSplits[0].equals( idA ) ) &&  ( !inputEleSplits[1].equals( idA ) )  )
            {
                continue;
            }

            if( inputEleSplits[0].equals( idA ) )
            {
                receivers.add( inputEleSplits[1] );
                aSendCnt += 1;
            }else // inputEleSplits[1].equals( idA )
            {
                senders.add( inputEleSplits[0] );
                aReceiveCnt += 1;
            }
            Integer tmpCnt = msgSendCntMap.get( inputEle );
            if( tmpCnt == null )
            {
                tmpCnt = 0;
            }
            tmpCnt += 1;
            msgSendCntMap.put( inputEle, tmpCnt );
        }

        int recSendCnt = 0;
        for( Iterator<String> iter = senders.iterator(); iter.hasNext(); )
        {
            String tmpSender = iter.next();
            if( receivers.contains( tmpSender ) )
            {
                recSendCnt ++;
            }
        }
        int L = receivers.size() - recSendCnt;

        int M = aSendCnt - aReceiveCnt;

        boolean existsX = false;
        for( Iterator<String> iter = receivers.iterator(); iter.hasNext(); )
        {
            String tmpReceiver = iter.next();
            Integer tmpSendCnt = msgSendCntMap.get( idA + " " + tmpReceiver );
            if( tmpSendCnt == null )
            {
                // will never come here
                continue;
            }

            Integer tmpReceiveCnt = msgSendCntMap.get( tmpReceiver + " " + idA );
            if( tmpReceiveCnt == null )
            {
                tmpReceiveCnt = 0;
            }
            if( tmpSendCnt - tmpReceiveCnt > 5 )
            {
                existsX = true;
                break;
            }
        }

        boolean isSpamSender = ( L > 5 ) || ( M > 5) || existsX;
        System.out.println( isSpamSender + " " + L + " " + M );
    }

}
