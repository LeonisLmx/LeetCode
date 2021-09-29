package Simple;

/**
 * @Author: Urey
 * @Date: 2021/8/17
 */
public class Title551 {

    public boolean checkRecord(String s){
        int len = s.length();
        int lateCount = 0,aCount = 0;
        for (int i = 0;i < len;i++){
            switch (s.charAt(i)){
                case 'L':
                    lateCount++;
                    if (lateCount >= 3){
                        return false;
                    }
                    break;
                case 'A':
                    aCount++;
                    if (aCount >= 2){
                        return false;
                    }
                default:
                    lateCount = 0;
            }
        }
        return true;
    }
}
