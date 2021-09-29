package niuke;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Author: Urey
 * @Date: 2021/8/20
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(reader.readLine());
        while (count > 0) {
            int length = Integer.parseInt(reader.readLine());
            String str = reader.readLine();
            int peopleLength = Integer.parseInt(reader.readLine());
            String strPeople = reader.readLine();
            setSeat(length,str,peopleLength,strPeople,writer);
            count--;
        }
        writer.flush();
    }

    private static void setSeat(int length,String table,int peopleLength, String people,BufferedWriter writer) throws IOException {
        Queue<Integer> zeroQueue = new ArrayBlockingQueue<>(length);
        Queue<Integer> oneQueue = new ArrayBlockingQueue<>(length);
        Queue<Integer> tempQueue = new ArrayBlockingQueue<>(length);
        for (int i = 0; i < length; i++) {
            if (table.charAt(i) == '0'){
                zeroQueue.offer(i + 1);
            }else if (table.charAt(i) == '1'){
                oneQueue.offer(i + 1);
            }
        }
        for (int i = 0; i < peopleLength; i++) {
            if (people.charAt(i) == 'M'){
                if (oneQueue.isEmpty() && tempQueue.isEmpty()){
                    int num = zeroQueue.poll();
                    tempQueue.offer(num);
                    writer.write(num + "");
                    writer.newLine();
                }else{
                    if (oneQueue.isEmpty()){
                        writer.write(tempQueue.poll() + "");
                        writer.newLine();
                        continue;
                    }
                    if (tempQueue.isEmpty()){
                        writer.write(oneQueue.poll() + "");
                        writer.newLine();
                        continue;
                    }
                    if (oneQueue.peek() < tempQueue.peek()){
                        writer.write(oneQueue.poll() + "");
                        writer.newLine();
                    }else{
                        writer.write(tempQueue.poll() + "");
                        writer.newLine();
                    }
                }
            }else{
                if (zeroQueue.isEmpty()){
                    if (oneQueue.isEmpty()){
                        writer.write(tempQueue.poll() + "");
                        writer.newLine();
                        continue;
                    }
                    if (tempQueue.isEmpty()){
                        writer.write(oneQueue.poll() + "");
                        writer.newLine();
                        continue;
                    }
                    if (oneQueue.peek() < tempQueue.peek()){
                        writer.write(oneQueue.poll());
                        writer.newLine();
                    }else{
                        writer.write(tempQueue.poll() + "");
                        writer.newLine();
                    }
                }else{
                    int num = zeroQueue.poll();
                    tempQueue.offer(num);
                    writer.write(num + "");
                    writer.newLine();
                }
            }
        }
    }
}
