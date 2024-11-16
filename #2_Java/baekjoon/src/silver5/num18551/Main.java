package silver5.num18551;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 숫자의 상한, 집합의 원소 개수, 숫자의 상한 이하인 가장 큰 수를 저장할 각 변수 초기화
	static int maxLimit;
	static int elementNum;
	static long maxNumber = Integer.MIN_VALUE;
	
	// 집합의 원소를 저장할 배열 elements 초기화
	static int[] elements;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 숫자의 상한과 집합의 원소 개수를 각 변수에 할당
		maxLimit = Integer.parseInt(st.nextToken());
		elementNum = Integer.parseInt(st.nextToken());
		
		// 집합의 원소를 저장할 배열 elements 초기화
		elements = new int[elementNum];
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 집합의 원소를 배열 elements에 할당
		for (int idx = 0; idx < elements.length; idx++)
			elements[idx] = Integer.parseInt(st.nextToken());
		
		// numberFinder() 메서드를 호출해 숫자의 상한 이하인 가장 큰 수를 갱신
		numberFinder(0);
		
		// valueOf() 및 write() 메서드를 사용해 숫자의 상한 이하인 가장 큰 수를 출력
		out.write(String.valueOf(maxNumber));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// numberFinder() 메서드 정의
	public static void numberFinder(long curNumber) {
		
		// 현재 숫자가 숫자의 상한을 초과하는 경우 메서드 종료
		if (curNumber > maxLimit)
			return;
		
		// max() 메서드를 사용해 숫자의 상한 이하인 가장 큰 수를 갱신
		maxNumber = Math.max(curNumber, maxNumber);
		
		// for 반복문을 사용해 집합에 속한 각 자연수를 더해 numberFinder() 메서드 재귀 호출 
		for (int digit : elements)
			numberFinder(curNumber * 10 + digit);
	}
}