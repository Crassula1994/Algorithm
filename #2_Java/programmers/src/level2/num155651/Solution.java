package level2.num155651;

// 필요한 패키지 불러오기
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static int solution(String[][] book_time) {

		// 방의 사용 가능 시작 시간을 저장할 PriorityQueue 객체 roomStatus 초기화
		PriorityQueue<Integer> roomStatus = new PriorityQueue<>();
		
		// sort() 메서드를 사용해 예약 시작 시간이 빠른 순, 예약 종료 시간이 빠른 순으로 2차원 배열 book_time 정렬
		Arrays.sort(book_time, (b1, b2) -> {
            return (b1[0].equals(b2[0])) ? b1[1].compareTo(b2[1]) : b1[0].compareTo(b2[0]);
        });
        
        // timeTransformer() 및 offer() 메서드를 사용해 첫 예약의 종료 시간을 roomStatus에 추가
        roomStatus.offer(timeTransformer(book_time[0][1]) + 10);
        
        // for 반복문을 사용해 다음 예약 시각을 차례로 순회
        for (int idx = 1; idx < book_time.length; idx++) {
        	
        	// timeTransformer() 메서드를 호출해 예약 시작 시각과 예약 종료 시각을 계산해 각 변수에 할당
            int startTime = timeTransformer(book_time[idx][0]);
            int endTime = timeTransformer(book_time[idx][1]) + 10;
            
            // poll() 메서드를 사용해 가장 빨리 예약이 가능한 방의 시간을 변수 lastTime에 할당
            int lastTime = roomStatus.poll();
            
            // 가장 빨리 예약이 가능한 방의 시간이 해당 예약의 시작 시간을 넘긴 경우
            if (lastTime > startTime) {
            	
            	// offer() 메서드를 사용해 필요한 방을 새로 추가한 것으로 처리
                roomStatus.offer(lastTime);
                roomStatus.offer(endTime);
                
            // 가장 빨리 예약이 가능한 방을 예약 가능한 경우 예약이 가능한 시간을 갱신
            } else {
                roomStatus.offer(endTime);
            }
        }
        
        // size() 메서드를 사용해 코니에게 필요한 최소 객실의 수를 변수 roomCnt에 할당
        int roomCnt = roomStatus.size();
        
        // 코니에게 필요한 최소 객실의 수를 반환
        return roomCnt;
    }
	
	// ----------------------------------------------------------------------------------------------------
    
	// timeTransformer() 메서드 정의
    public static int timeTransformer(String timeString) {
        
    	// StringTokenizer 객체를 불러와 변수 st에 할당
        StringTokenizer st = new StringTokenizer(timeString, ":");
        
        // nextToken() 및 parseInt() 메서드를 사용해 입력 받은 시간의 시간과 분을 각 변수에 할당
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        
        // 시간을 분으로 환산해 변수 time에 할당
        int time = hour * 60 + minute;
        
        // 시간 문자열을 분으로 환산한 결과를 반환
        return time;
    }
}