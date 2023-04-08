package silver4.num01015;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 배열의 크기를 변수 size에 할당
		int size = Integer.parseInt(in.readLine());
		
		// 배열의 원소를 저장할 각 2차원 배열 초기화
		int[][] sequenceA = new int[size][2];
		int[][] sequenceB = new int[size][2];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 배열 sequenceA의 각 원소를 순회
		for (int idx = 0; idx < size; idx++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 배열의 원소를 배열 sequenceA에 저장
			sequenceA[idx][0] = Integer.parseInt(st.nextToken());
			
			// 해당 원소의 인덱스를 배열 sequenceA에 저장
			sequenceA[idx][1] = idx;
		}
		
		// sort() 메서드를 사용해 배열 sequenceA를 오름차순 정렬
		Arrays.sort(sequenceA, (e1, e2) -> {
			return (e1[0] == e2[0]) ? e1[1] - e2[1] : e1[0] - e2[0];
		});
		
		// for 반복문을 사용해 배열 sequenceB의 각 원소를 순회
		for (int idx = 0; idx < size; idx++) {
			
			// 정렬하기 전의 인덱스와 정렬한 후의 인덱스를 배열 sequenceB에 저장
			sequenceB[idx][0] = sequenceA[idx][1];
			sequenceB[idx][1] = idx;
		}
		
		// sort() 메서드를 사용해 배열 sequenceB를 오름차순 정렬
		Arrays.sort(sequenceB, (e1, e2) -> {
			return e1[0] - e2[0];
		});
		
		// for 반복문을 사용해 비내림차순으로 만드는 수열을 출력
		for (int idx = 0; idx < size; idx++)
			out.write(sequenceB[idx][1] + " ");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}