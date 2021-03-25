package jongmanbook.Chap06;

public class BoggleGame {
/*
    static final int[] dx = {-1, -1, -1, 1, 1, 1, 0, 0, 0};
    static final int[] dy = {-1, 0, 1, -1, 0, 1, -1, 0, 1};

    //5 * 5의 보글 게임 판의 해당 위치에서 주어진 단어가 시작하는지를 반환
    static boolean hasWord(int y, int x, String word) {
        //기저 사례 1: 시작 위치가 범위 밖이면 무조건 실패
        if(!inRange(y, x)) return false;
        //기저 사례 2: 첫 글자가 일치하지 않으면 실패
        if(board[y][x] != work[0]) return false;
        //기저 사례 3: 단어 길이가 1이면 성공
        if(word.length() == 1) return true;
        //인접한 여덟 칸틀 검사한다.
        for(int direction = 0; direction < 8; ++direction) {
            //다음 칸이 범위 안에 있는지, 첫 글자는 일치하는지 확인할 필요가 없다.
            int nextY = y + dy[direction];
            int nextX = x + dx[direction];
            if(hasWord(nextY, nextX, word.substring(1)));
            return true;
        }
        return false;
    }*/
}
