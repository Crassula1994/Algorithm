package bronze5.num10757;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 toCharArray() 메서드를 사용해 입력 받은 각 숫자를 배열에 저장
		char[] a = st.nextToken().toCharArray();
		char[] b = st.nextToken().toCharArray();
		
		// max() 메서드를 사용해 두 배열 중 가장 긴 배열의 길이를 변수 maxLength에 할당
		int maxLength = Math.max(a.length, b.length);
		
		// 각 배열을 반대로 저장할 각 배열 초기화
		int[] reverseA = new int[maxLength];
		int[] reverseB = new int[maxLength];
		
		// 연산 결과를 저장할 배열 result 초기화
		int[] result = new int[maxLength + 1];
		
		// for 반복문을 사용해 배열 a를 거꾸로 저장
		for (int i = a.length - 1, index = 0; i >= 0; i--)
			reverseA[index++] = a[i] - '0';
		
		// for 반복문을 사용해 배열 b를 거꾸로 저장
		for (int j = b.length - 1, index = 0; j >= 0; j--)
			reverseB[index++] = b[j] - '0';
		
		// for 반복문을 사용해 뒤집은 각 배열의 원소를 순회
		for (int k = 0; k < maxLength; k++) {

			// 덧셈을 수행한 결과를 변수 sum에 할당
			int sum = result[k] + reverseA[k] + reverseB[k];

			// 10 이상의 값을 다음 자릿수에 저장
			result[k + 1] += sum / 10;
			
			// 덧셈 연산 결과를 배열 result에 저장
			result[k] = sum % 10;
		}
		
		// 가장 높은 자릿수가 0이 아닐 경우 높은 자릿수 출력
		if (result[maxLength] != 0)
			out.write(String.valueOf(result[maxLength]));
		
		// for 반복문을 사용해 덧셈 연산 결과의 각 자릿수를 출력
		for (int l = maxLength - 1; l >= 0; l--)
			out.write(String.valueOf(result[l]));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}