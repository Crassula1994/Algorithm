package silver2.num01138;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 사람의 수를 변수 length에 할당
		int length = Integer.parseInt(in.readLine());
		
		// 각 줄에 선 사람들이 기억하는 정보를 저장할 배열 info 초기화
		int[] info = new int[length];
		
		// 각 사람들이 줄을 선 순서를 저장할 List 객체 lineList 초기화
		List<Integer> lineList = new ArrayList<>();
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 사람들이 기억하는 정보를 배열 info에 저장
		for (int idx = 0; idx < info.length; idx++)
			info[idx] = Integer.parseInt(st.nextToken());
		
		// for 반복문을 사용해 각 사람들이 줄을 선 순서를 lineList에 저장
		for (int idx = length - 1; idx >= 0; idx--)
			lineList.add(info[idx], idx + 1);
		
		// for 반복문을 사용해 각 사람들이 줄을 선 순서대로 키를 출력
		for (int idx = 0; idx < lineList.size(); idx++)
			out.write(lineList.get(idx) + " ");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}