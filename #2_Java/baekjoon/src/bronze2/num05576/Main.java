package bronze2.num05576;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// W 대학과 K 대학의 점수를 저장할 각 변수 초기화
		int scoreW = 0;
		int scoreK = 0;
		
		// 가장 높은 3명의 점수를 산출할 각 PriorityQueue 객체 초기화
		PriorityQueue<Integer> sorterW = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> sorterK = new PriorityQueue<>(Collections.reverseOrder());
		
		// for 반복문을 사용해 W 대학 참가자의 점수를 sorterW에 저장
		for (int w = 0; w < 10; w++)
			sorterW.offer(Integer.parseInt(in.readLine()));
		
		// for 반복문을 사용해 W 대학의 점수를 갱신
		for (int w = 0; w < 3; w++)
			scoreW += sorterW.poll();
		
		// for 반복문을 사용해 K 대학 참가자의 점수를 sorterK에 저장
		for (int k = 0; k < 10; k++)
			sorterK.offer(Integer.parseInt(in.readLine()));
		
		// for 반복문을 사용해 K 대학의 점수를 갱신
		for (int k = 0; k < 3; k++)
			scoreK += sorterK.poll();
		
		// write() 메서드를 사용해 W 대학과 K 대학의 점수를 출력
		out.write(scoreW + " " + scoreK);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}