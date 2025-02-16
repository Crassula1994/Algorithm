package gold3.num31854;

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
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 부등호 퍼즐의 크기를 변수 size에 할당
		int size = Integer.parseInt(in.readLine());
		
		// 부등호 퍼즐의 대소 관계를 저장할 배열 relations 초기화
		List<Integer>[] relations = new ArrayList[size * size];
		
		// for 반복문을 사용해 부등호 퍼즐의 대소 관계를 저장할 List 객체 초기화
		for (int idx = 0; idx < relations.length; idx++)
			relations[idx] = new ArrayList<>();
		
		// for 반복문을 사용해 각 행을 순회
		for (int r = 0; r < size; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 각 칸 사이의 부등호를 순회
			for (int c = 0; c < size - 1; c++) {
				
				// 연결하는 두 칸의 번호를 각 변수에 할당
				int leftCell = r * size + c;
				int rightCell = leftCell + 1;
				
				// 해당 부등호가 '>'인 경우 대소 관계를 relations에 저장
				if (st.nextToken().equals(">")) {
					relations[rightCell].add(leftCell);
				
				// 해당 부등호가 '<'인 경우 대소 관계를 relations에 저장
				} else {
					relations[leftCell].add(rightCell);
				}
			}
		}
		
		// for 반복문을 사용해 각 행 사이를 순회
		for (int r = 0; r < size - 1; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 각 칸의 부등호를 순회
			for (int c = 0; c < size; c++) {
				
				// 연결하는 두 칸의 번호를 각 변수에 할당
				int upCell = r * size + c;
				int downCell = upCell + size;
				
				// 해당 부등호가 '>'인 경우 대소 관계를 relations에 저장
				if (st.nextToken().equals(">")) {
					relations[downCell].add(upCell);
				
				// 해당 부등호가 '<'인 경우 대소 관계를 relations에 저장
				} else {
					relations[upCell].add(downCell);
				}
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}