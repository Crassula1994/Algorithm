package gold3.num17237;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 메서드를 사용해 입력 받은 군사들의 수를 변수 soldierNum에 할당
		int soldierNum = Integer.parseInt(in.readLine());
		
		// 성으로부터 떨어진 거리에 따른 군사들의 수를 저장할 배열 counts 초기화
		int[] counts = new int[21];
		
		// while 반복문을 사용해 성으로부터 떨어진 거리에 따른 군사들의 수를 counts에 저장
		while (soldierNum-- > 0)
			counts[Integer.parseInt(in.readLine())]++;
		
		// for 반복문을 사용해 멀리 떨어진 군사들부터 군사들을 절반씩 나누어 배치해 한 칸 전진시킨 뒤 회수한 것으로 처리
		for (int distance = 20; distance >= 1; distance--)
			counts[distance - 1] += counts[distance] / 2;
		
		// 성에 도달한 병사가 있는지 여부에 따라 승리한 사람을 출력
		out.write((counts[0] > 0) ? "A" : "B");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}