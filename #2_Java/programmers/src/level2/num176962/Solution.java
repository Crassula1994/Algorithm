package level2.num176962;

// 필요한 패키지 불러오기
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

// Solution 클래스 정의
public class Solution {
	
	// Homework 클래스 정의
	public static class Homework {
		
		// 과제의 이름 및 남은 시간을 저장할 각 변수 초기화
        String name;
        int remainTime;
        
        // 인자를 입력 받는 생성자 정의
        public Homework(String name, int remainTime) {
            this.name = name;
            this.remainTime = remainTime;
        }
    }
	
	// ----------------------------------------------------------------------------------------------------
	
	// solution() 메서드 정의
	public static String[] solution(String[][] plans) {
		
		// 과제를 저장할 인덱스를 나타낼 변수 index 초기화
		int index = 0;
		
		// 과제를 끝낸 순서를 저장할 배열 order 초기화
		String[] order = new String[plans.length];
		
		// 과제의 남은 시간을 저장할 Stack 객체 remains 초기화
		Stack<Homework> remains = new Stack<>();
		
		// compareTo() 및 sort() 메서드를 사용해 입력 받은 과제 목록을 시작 시각을 기준으로 오름차순 정렬
		Arrays.sort(plans, (p1, p2) -> {
            return p1[1].compareTo(p2[1]);
        });
        
        // for 반복문을 사용해 각 과제를 순회
        for (int idx = 0; idx < plans.length - 1; idx++) {
            
        	// 현재 과제의 이름을 변수 curName에 할당
            String curName = plans[idx][0];
            
            // timeTransformer() 메서드를 호출해 현재 과제와 다음 과제의 시작 시간을 분 단위로 변경해 각 변수에 할당
            int curStart = timeTransformer(plans[idx][1]);
            int nextStart = timeTransformer(plans[idx + 1][1]);
            
            // parseInt() 메서드를 사용해 현재 과제의 소요 시간을 변수 curName에 할당
            int curPlaytime = Integer.parseInt(plans[idx][2]);
            
            // 과제의 예상 종료 시간을 계산해 변수 curEnd에 할당
            int curEnd = curStart + curPlaytime;
            
            // 과제의 예상 종료 시간이 다음 과제 시작 시간보다 적거나 이전인 경우
            if (curEnd <= nextStart) {
            	
            	// 현재 과제를 완료 처리
                order[index++] = curName;
                
                // while 반복문을 사용해 remains가 빌 때까지 순회
                while (!remains.isEmpty()) {
                    
                	// pop() 메서드를 사용해 남은 과제 중 가장 최근에 진행한 과제를 변수 homework에 할당
                    Homework homework = remains.pop();
                    
                    // 해당 과제를 끝냈을 때의 예상 종료 시간을 계산해 변수 newEnd에 할당
                    int newEnd = curEnd + homework.remainTime;
                    
                    // 해당 과제를 다음 과제의 시작 시간 이전에 끝낼 수 없는 경우
                    if (newEnd > nextStart) {
                    	
                    	// 추가로 진행한 과제의 남은 시간을 갱신
                        homework.remainTime -= nextStart - curEnd;
                        
                        // push() 메서드를 사용해 해당 과제를 다시 remains에 추가
                        remains.push(homework);
                        
                        // 반복문 탈출
                        break;
                    }
                    
                    // 예상 종료 시간을 갱신
                    curEnd = newEnd;
                    
                    // 추가로 진행한 과제를 완료 처리
                    order[index++] = homework.name;
                }
                
            // 과제의 예상 종료 시간이 다음 과제 시작 시간 이후인 경우 remains에 추가
            } else {
                remains.push(new Homework(curName, curEnd - nextStart));
            }
        }
        
        // 시작 시각이 가장 마지막인 과제를 완료 처리
        order[index++] = plans[plans.length - 1][0];
        
        // while 반복문을 사용해 남아 있는 과제를 차례로 완료 처리
        while (!remains.isEmpty())
            order[index++] = remains.pop().name;
        
        // 과제를 끝낸 순서를 저장한 배열 반환
        return order;
    }
	
	// ----------------------------------------------------------------------------------------------------
	
	// timeTransformer() 메서드 정의
	public static int timeTransformer(String timeStr) {
        
		// StringTokenizer 객체를 불러와 변수 st에 할당
        StringTokenizer st = new StringTokenizer(timeStr, ":");
        
        // nextToken() 및 parseInt() 메서드를 사용해 입력 받은 시간과 분을 각 변수에 할당
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        
        // 시간 문자열을 분 단위 시간으로 바꾸어 반환
        return hour * 60 + minute;
    }
}