package bronze1.num32158;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 원래 문구의 길이를 변수 length에 할당
		int length = Integer.parseInt(in.readLine());
		
		// readLine() 및 toCharArray() 메서드를 사용해 입력 받은 문구를 배열 phrase에 저장
		char[] phrase = in.readLine().toCharArray();
		
		// P와 C의 위치를 저장할 각 List 객체 초기화
		List<Integer> indexC = new ArrayList<>();
		List<Integer> indexP = new ArrayList<>();
		
		// for 반복문을 사용해 각 문구의 글자를 순회
		for (int idx = 0; idx < length; idx++) {
			
			// 해당 글자가 C인 경우 해당 인덱스를 indexC에 저장
			if (phrase[idx] == 'C') {
				indexC.add(idx);
				
			// 해당 글자가 P인 경우 해당 인덱스를 indexP에 저장
			} else if (phrase[idx] == 'P') {
				indexP.add(idx);
			}
		}
		
		// for 반복문을 사용해 각 P와 C의 쌍에 해당하는 글자를 교체
		for (int pair = 0; pair < Math.min(indexC.size(), indexP.size()); pair++) {
			phrase[indexC.get(pair)] = 'P';
			phrase[indexP.get(pair)] = 'C';
		}
		
		// write() 메서드를 사용해 디자이너가 수정한 이후의 문구를 출력
		out.write(new String(phrase));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}