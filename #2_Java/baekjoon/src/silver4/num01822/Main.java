package silver4.num01822;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 집합 A와 집합 B의 원소의 개수를 각 변수에 할당
		int sizeA = Integer.parseInt(st.nextToken());
		int sizeB = Integer.parseInt(st.nextToken());
		
		// 차집합의 원소를 저장할 Set 객체 differenceSet 초기화
		Set<Integer> differenceSet = new TreeSet<>();
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 집합 A의 원소를 differenceSet에 추가
		for (int e = 0; e < sizeA; e++)
			differenceSet.add(Integer.parseInt(st.nextToken()));
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 집합 B의 원소를 순회
		for (int e = 0; e < sizeB; e++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 집합 B의 원소를 변수 element에 할당
			int element = Integer.parseInt(st.nextToken());
			
			// 해당 원소가 차집합에 존재하는 경우 해당 원소 제거
			if (differenceSet.contains(element))
				differenceSet.remove(element);
		}
		
		// write() 메서드를 사용해 차집합의 크기를 출력
		out.write(differenceSet.size() + "\n");
		
		// for 반복문을 사용해 차집합의 원소를 차례로 출력
		for (int element : differenceSet)
			out.write(element + " ");

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}