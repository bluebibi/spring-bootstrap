package com.thinkonweb.tiis.service;

import com.thinkonweb.tiis.domain.Manuscript;
import com.thinkonweb.tiis.mapper.ManuscriptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManuscriptService {
    @Autowired
    private ManuscriptMapper manuscriptMapper;

    public Manuscript getManuscriptById(int id) {
        return null;
    }

    public void upload(Manuscript manuscript) {
        // s3에 논문 파일 업로드, 논문 파일 경로 획득
        // 입력된 manuscript 데이터 manuscripts 테이블에 저장
        // keyword 콤마 분리하여 keywords 테이블에 저장
        // authors 콤마 분리하여 authors 테이블에 저장

    }

    public void update(Manuscript manuscript) {

    }
}
