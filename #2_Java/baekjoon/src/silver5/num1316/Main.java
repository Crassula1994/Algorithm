package silver5.num1316;

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
	
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 단어의 개수를 변수 count에 저장
		int count = Integer.parseInt(in.readLine());
		
		// 그룹 단어의 개수를 저장할 변수 groupCount 초기화
		int groupCount = 0;
		
		// for 반복문을 사용해 각 단어를 순회
		for (int i = 0; i < count; i++) {
			
			// readLine() 및 toCharArray() 메서드를 사용해 입력 받은 단어를 배열 characterArray에 저장
			char[] characterArray = in.readLine().toCharArray();
			
			// 각 단어의 개수를 담을 배열 alphabets 초기화
			int[] alphabets = new int[26];
			
			// for 반복문을 사용해 characterArray 배열의 각 원소를 순회
			for (int j = 0; j < characterArray.length; j++) {
				
				// 해당 단어의 인덱스를 변수 index에 할당
				int index = characterArray[j] - 'a';
				
				// 그룹 단어가 아닌 경우 반복문 탈출
				if (j > 0 && alphabets[index] != 0 && index != characterArray[j - 1] - 'a')
					break;
				
				// 해당 알파벳의 개수를 갱신
				alphabets[index] += 1;
				
				// 그룹 단어인 경우 그룹 단어의 개수 갱신
				if (j == characterArray.length - 1)
					groupCount++;
			}
		}

		// valueOf(), write() 메서드를 사용해 그룹 단어의 개수를 출력
		out.write(String.valueOf(groupCount));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}