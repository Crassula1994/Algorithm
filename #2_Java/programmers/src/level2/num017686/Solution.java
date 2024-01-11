package level2.num017686;

// 필요한 패키지 불러오기
import java.util.PriorityQueue;

// Solution 클래스 정의
public class Solution {
	
	// File 클래스 정의
	public static class File implements Comparable<File> {
		
		// 파일의 이름, 헤드 부분, 숫자, 순서를 저장할 각 변수 초기화
        String name;
        String head;
        int number;
        int order;
        
        // 인자를 입력 받는 생성자 정의
        public File(String name, String head, int number, int order) {
            this.name = name;
            this.head = head;
            this.number = number;
            this.order = order;
        }
        
        // compareTo() 메서드 정의
        @Override
        public int compareTo(File anotherFile) {
            
        	// 파일의 헤드 부분이 같은 경우
            if (head.equals(anotherFile.head)) {
                
            	// 파일의 숫자가 같은 경우 파일 순서에 따라 정렬
                if (number == anotherFile.number)
                    return order - anotherFile.order;
                
                // 파일의 숫자 순으로 오름차순으로 정렬
                return number - anotherFile.number;
            }
            
            // 파일의 헤드 부분을 사전 순으로 정렬
            return head.compareTo(anotherFile.head);
        }
    }
	
	// ----------------------------------------------------------------------------------------------------
	
	// solution() 메서드 정의
	public static String[] solution(String[] files) {

		// 정렬된 파일의 배열을 저장할 배열 sortedFiles 초기화 
		String[] sortedFiles = new String[files.length];
		
		// 파일을 정렬할 PriorityQueue 객체 fileSorter 초기화
		PriorityQueue<File> fileSorter = new PriorityQueue<>();
        
        // for 반복문을 사용해 각 파일을 차례로 순회
        for (int idx = 0; idx < files.length; idx++) {
        	
        	// 해당 파일의 이름을 변수 name에 할당
            String name = files[idx];
            
            // 해당 파일의 숫자 부분과 꼬리 부분의 시작 인덱스를 저장할 각 변수 초기화
            int numberIdx = -1;
            int tailIdx = -1;
            
            // for 반복문을 사용해 파일 이름의 각 글자를 차례로 순회
            for (int c = 0; c < name.length(); c++) {
                
            	// charAt() 메서드를 사용해 해당 위치의 글자를 변수 character에 할당
                char character = name.charAt(c);
                
                // 해당 파일의 숫자 부분을 찾은 경우 숫자 부분의 시작 인덱스를 갱신
                if (numberIdx == -1 && character > 47 && character < 65) {
                    numberIdx = c;
                
                // 해당 파일의 꼬리 부분을 찾은 경우 꼬리 부분의 시작 인덱스를 갱신 후 반복문 탈출
                } else if (numberIdx != -1 && (character < 48 || character > 64)) {
                    tailIdx = c;
                    break;
                }
            }
            
            // substring() 및 toLowerCase() 메서드를 사용해 해당 파일의 헤드 부분을 변수 head에 할당
            String head = name.substring(0, numberIdx).toLowerCase();
            
            // substring() 및 parseInt() 메서드를 사용해 해당 파일의 숫자 부분을 변수 number에 할당
            int number = (tailIdx == -1) ?
            		Integer.parseInt(name.substring(numberIdx)) : Integer.parseInt(name.substring(numberIdx, tailIdx));
            
            // offer() 메서드를 사용해 해당 파일을 fileSorter에 추가
            fileSorter.offer(new File(name, head, number, idx));
        }
        
        // 정렬된 파일의 배열의 인덱스를 나타낼 변수 index 초기화
        int index = 0;
        
        // while 반복문을 사용해 정렬된 파일명을 배열 sortedFiles에 저장
        while (!fileSorter.isEmpty())
            sortedFiles[index++] = fileSorter.poll().name;
        
        // 정렬된 파일의 배열을 반환
        return sortedFiles;
    }
}