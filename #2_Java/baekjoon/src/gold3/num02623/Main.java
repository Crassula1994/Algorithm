package gold3.num02623;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 가수의 수 및 보조 PD의 수를 각 변수에 할당
		int singerNum = Integer.parseInt(st.nextToken());
		int producerNum = Integer.parseInt(st.nextToken());
		
		// 각 가수의 앞선 가수의 수를 저장할 배열 preOrder 초기화
		int[] preOrder = new int[singerNum + 1];
		
		// 각 가수의 순서를 저장할 배열 orders 초기화
		@SuppressWarnings("unchecked")
		List<Integer>[] orders = new ArrayList[singerNum + 1];
		
		// for 반복문을 사용해 각 가수별 순서를 저장할 List 객체 초기화
		for (int idx = 0; idx < orders.length; idx++)
			orders[idx] = new ArrayList<>();

		// for 반복문을 사용하여 각 보조 PD의 가수 순서를 순회
		for (int producer = 0; producer < producerNum; producer++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 담당 가수의 수, 현재 가수를 각 변수에 할당
			int singerCnt = Integer.parseInt(st.nextToken());
			int currentSinger = Integer.parseInt(st.nextToken());
			
			// for 반복문을 사용해 각 담당 가수를 순회
			for (int s = 1; s < singerCnt; s++) {
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 다음 가수를 변수 nextSinger에 할당
				int nextSinger = Integer.parseInt(st.nextToken());
				
				// add() 메서드를 사용해 각 가수별 순서 추가 및 앞선 가수의 수를 갱신
				orders[currentSinger].add(nextSinger);
				preOrder[nextSinger]++;
				
				// 현재 가수를 갱신
				currentSinger = nextSinger;
			}
		}
		
		// 각 가수의 실제 출연 순서 및 순서를 확인할 각 Queue 객체 초기화
		Queue<Integer> actualOrder = new LinkedList<>();
		Queue<Integer> orderList = new LinkedList<>();
		
		// for 반복문을 사용해 preOrder의 각 원소를 순회
		for (int idx = 1; idx < preOrder.length; idx++) {
			
			// 앞선 가수가 존재하지 않는 가수인 경우 actualOrder 및 orderList에 추가
			if (preOrder[idx] == 0) {
				actualOrder.offer(idx);
				orderList.offer(idx);
			}
		}
			
		// while 반복문을 사용해 orderList가 빌 때까지 순회
		while (!orderList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 확인 중인 가수를 변수 currentSinger에 할당
			int currentSinger = orderList.poll();
			
			// for 반복문을 사용해 현재 확인 중인 가수가 앞선 가수인 가수를 순회
			for (int idx = 0; idx < orders[currentSinger].size(); idx++) {
				
				// get() 메서드를 사용해 현재 확인 중인 가수가 앞선 가수인 가수를 변수 nextSinger에 할당
				int nextSinger = orders[currentSinger].get(idx);
				
				// 해당 가수의 앞선 가수의 수를 갱신
				preOrder[nextSinger]--;
				
				// 해당 가수의 앞선 가수가 존재하지 않는 경우 actualOrder 및 orderList에 추가
				if (preOrder[nextSinger] == 0) {
					actualOrder.offer(nextSinger);
					orderList.offer(nextSinger);
				}
			}
		}
		
		// 남일이가 순서를 정하는 것이 불가능한 경우 0을 출력
		if (actualOrder.size() != singerNum) {
			out.write(String.valueOf(0));
		
		// 남일이가 순서를 정하는 것이 가능한 경우
		} else {
			
			// while 반복문을 사용해 남일이가 정한 가수들의 출연 순서를 출력
			while (!actualOrder.isEmpty())
				out.write(actualOrder.poll() + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}