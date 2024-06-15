package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//@Service //해당 애너테이션이 있으면 스프링 컨테이너에 자동으로 등록해줌
@Transactional //JPA를 통한 모든 데이터 변경은 트랜잭션 안에서 실행해야 함
public class MemberService {

    private final MemberRepository memberRepository;

    //외부에서 repository를 주입 -> Dependency Injection(DI)
    //@Autowired //자동으로 넣어줌!!
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //회원 가입
    public Long join(Member member) {
        //같은 이름을 가진 중복 회원 X
        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    //extract method(ctrl+alt+m) 기능을 통해 메서드로 추출함
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    //전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
