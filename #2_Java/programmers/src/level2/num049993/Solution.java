package level2.num049993;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static int solution(String skill, String[] skill_trees) {
		
		// 가능한 스킬 트리의 개수를 저장할 변수 count 초기화
		int count = 0;
		
		// 각 스킬의 순서를 저장할 배열 orders 초기화
		int[] orders = new int[26];
        
		// for 반복문을 사용해 선행 스킬 순서의 각 스킬을 순회
        for (int idx = 0; idx < skill.length(); idx++) {
        	
        	// charAt() 메서드를 사용해 선행 스킬을 변수 preSkill에 할당
            char preSkill = skill.charAt(idx);
            
            // 해당 선행 스킬의 순서를 배열 orders에 추가
            orders[preSkill - 'A'] = idx + 1;
        }
        
        // for 반복문을 사용해 유저들이 만든 각 스킬 트리를 순회
        for (int i = 0; i < skill_trees.length; i++) {
            
        	// 해당 스킬 트리를 변수 skillTree에 할당
            String skillTree = skill_trees[i];
            
            // 현재까지 나온 선행 스킬의 순서, 가능한 스킬 트리인지를 나타낼 각 변수 초기화
            int topOrder = 0;
            boolean isPossible = true;
            
            // for 반복문을 사용해 해당 스킬 트리의 각 스킬을 순회
            for (int j = 0; j < skillTree.length(); j++) {
            	
            	// charAt() 메서드를 사용해 확인 중인 스킬을 변수 currentSkill에 할당
                char currentSkill = skillTree.charAt(j);
                
                // 해당 스킬이 선행 스킬이 아닌 경우 다음 스킬을 순회
                if (orders[currentSkill - 'A'] == 0)
                    continue;
                   
                // 해당 스킬이 선행 스킬 트리에 부합하는 스킬인 경우 현재까지 나온 선행 스킬의 순서 갱신
                if (orders[currentSkill - 'A'] == topOrder + 1) {
                    topOrder = orders[currentSkill - 'A'];
                
                // 해당 스킬이 선행 스킬 트리에 부합하지 않는 경우
                } else {
                	
                	// 가능한 스킬 트리인지를 나타내는 변수 갱신 후 반복문 탈출
                    isPossible = false;
                    break;
                }
            }
            
            // 가능한 스킬 트리인 경우 가능한 스킬 트리의 개수를 갱신
            if (isPossible)
                count++;
        }

        // 가능한 스킬 트리의 개수를 반환
        return count;
    }
}