package gold2.num01202;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// Jewel 클래스 정의
	public static class Jewel implements Comparable<Jewel> {
		
		// 보석의 무게와 가격을 저장할 각 변수 초기화
		int weight;
		int value;
		
		// 매개변수를 입력 받는 생성자 정의
		public Jewel(int weight, int value) {
			this.weight = weight;
			this.value = value;
		}

		// compareTo() 메서드 정의
		@Override
		public int compareTo(Jewel otherJewel) {
			return (weight == otherJewel.weight) ? otherJewel.value - value : weight - otherJewel.weight;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 보석의 개수 및 가방의 개수를 각 변수에 할당
		int jewelNum = Integer.parseInt(st.nextToken());
		int bagNum = Integer.parseInt(st.nextToken());
		
		// 상덕이가 훔칠 수 있는 보석 가격의 합의 최댓값을 저장할 변수 maxValue 초기화
		long maxValue = 0;
		
		// 보석의 정보 및 가방의 무게를 저장할 각 List 객체 초기화
		List<Jewel> jewels = new ArrayList<>();
		List<Integer> bags = new ArrayList<>();
		
		// for 반복문을 사용해 각 보석의 정보를 순회
		for (int jewel = 0; jewel < jewelNum; jewel++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 보석의 무게와 가치를 각 변수에 할당
			int weight = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			// add() 메서드를 사용해 해당 보석의 정보를 배열 jewels에 저장
			jewels.add(new Jewel(weight, value));
		}
		
		// for 반복문을 사용해 입력 받은 각 가방의 무게를 배열 bags에 저장
		for (int bag = 0; bag < bagNum; bag++)
			bags.add(Integer.parseInt(in.readLine()));
		
		// sort() 메서드를 사용해 각 배열을 오름차순으로 정렬
		Collections.sort(jewels);
		Collections.sort(bags);
		
		// 가방에 넣을 수 있는 보석을 선택할 PriorityQueue 객체 jewelSelector 초기화
		PriorityQueue<Jewel> jewelSelector = new PriorityQueue<>((j1, j2) -> {
			return j2.value - j1.value;
		});
		
		// 현재 확인 중인 보석의 순서를 저장할 변수 curJewel 초기화
		int curJewel = 0;
		
		// for 반복문을 사용해 각 가방을 순회
		for (int bag : bags) {
			
			// for 반복문을 사용해 각 보석을 순회
			for (int idx = curJewel; idx < jewelNum; idx++) {
				
				// 해당 보석의 무게가 가방의 무게를 초과하는 경우 
				if (jewels.get(idx).weight > bag) {
					
					// 현재 확인 중인 보석의 순서를 갱신 후 반복문 탈출
					curJewel = idx;
					break;
				}
				
				// offer() 메서드를 사용해 해당 보석의 정보를 jewelSelector에 추가
				jewelSelector.offer(jewels.get(idx));
				
				// 마지막 보석에 도달한 경우 현재 확인 중인 보석의 순서를 갱신
				if (idx == jewelNum - 1)
					curJewel = jewelNum;
			}
			
			// 가방에 담을 수 있는 보석이 없는 경우 다음 가방을 순회
			if (jewelSelector.isEmpty())
				continue;
			
			// poll() 메서드를 사용해 상덕이가 훔칠 수 있는 보석 가격의 합의 최댓값을 갱신
			maxValue += jewelSelector.poll().value;
		}
		
		// valueOf() 및 write() 메서드를 사용해 상덕이가 훔칠 수 있는 보석 가격의 합의 최댓값을 출력
		out.write(String.valueOf(maxValue));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}