package silver4.num21554;

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
	
	// 현재 놓인 장난감의 크기를 저장할 배열 toys 초기화
	static int[] toys;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 장난감의 수를 변수 toyNum에 할당
		int toyNum = Integer.parseInt(in.readLine());
		
		// 현재 놓인 장난감의 크기를 저장할 배열 toys 초기화
		toys = new int[toyNum + 1];
		
		// 각 조작 시 영향을 받는 장난감의 위치를 저장할 List 객체 controls 초기화
		List<int[]> controls = new ArrayList<>();
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 장난감의 크기를 배열 toys에 저장
		for (int idx = 1; idx < toys.length; idx++)
			toys[idx] = Integer.parseInt(st.nextToken());
		
		// for 반복문을 사용해 각 장난감의 번호를 순회
		for (int idx = 1; idx < toys.length; idx++) {
			
			// 해당 장난감이 정렬된 위치에 있는 경우 다음 장난감을 순회
			if (toys[idx] == idx)
				continue;
			
			// toyFinder() 메서드를 호출해 해당 장난감의 위치에 와야할 다른 장난감의 위치를 변수 targetIdx에 할당
			int targetIdx = toyFinder(idx);
			
			// add() 메서드를 사용해 조작을 시행할 장난감의 위치를 controls에 저장
			controls.add(new int[] {idx, targetIdx});
			
			// toyController() 메서드를 호출해 해당 위치의 장난감을 뒤집기
			toyController(idx, targetIdx);
		}
		
		// 조작횟수가 100번을 초과하는 경우 -1을 출력
		if (controls.size() > 100) {
			out.write(String.valueOf(-1));
			
		// 조작횟수가 100번 이하인 경우
		} else {
			
			// size() 및 write() 메서드를 사용해 조작횟수를 출력
			out.write(controls.size() + "\n");
			
			// for 반복문을 사용해 각 조작 시 이동한 장난감의 위치를 출력
			for (int[] control : controls)
				out.write(control[0] + " " + control[1] + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// toyFinder() 메서드 정의
	public static int toyFinder(int targetSize) {
		
		// for 반복문을 사용해 각 장난감의 위치를 순회
		for (int idx = 1; idx < toys.length; idx++) {
			
			// 해당 위치에 찾는 장난감이 있는 경우 해당 위치를 반환
			if (toys[idx] == targetSize)
				return idx;
		}
		
		// 찾는 값이 없는 경우 -1 반환
		return -1;
	}
	
	// ----------------------------------------------------------------------------------------------------

	// toyController() 메서드 정의
	public static void toyController(int leftIdx, int rightIdx) {
		
		// while 반복문을 사용해 위치를 뒤바꿀 각 장난감을 순회
		while (leftIdx < rightIdx) {
			
			// 두 장난감의 위치를 바꾸기
			int temp = toys[leftIdx];
			toys[leftIdx] = toys[rightIdx];
			toys[rightIdx] = temp;
			
			// 바꿀 장난감의 위치를 갱신
			leftIdx++;
			rightIdx--;
		}
	}
}