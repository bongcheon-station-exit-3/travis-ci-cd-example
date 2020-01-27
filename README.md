# Travis CI/CD 
1. travis CI 가입 및 repo 들에 대한 travis 액세스 권한 허용.
  - 본인 repo 는 모두 액세스 가능
  - `org` 는 해당 권한이 있으면 가능 (grant 로 줄 수 있음) 
  - `org` 는 없으면 request 를 통해 권한 요청을 수행할 수 있음
2. `.travis.yml` 파일 root 에 생성 및 하위 내용 삽입.
```yml
languge: java
install: true

os: linux
dist: trusty
jdk: openjdk8

notification:
    email: oraedoa@gmail.com

before_script:
    - echo "Before Script"

# 프로젝트 빌드의 전체적인 상황을 확인할 수 있도록 설정하는 옵션 (--scan)
script:
    - echo "Hello World"
    - ./gradlew build

after_success:
    - echo "After Success"

after_script:
    - echo "After Scirpt"
```
3. gradlew 에 퍼미션 문제가 나타나기 때문에 해결해야함. (permission denied)
    1. `before_install` 을 통해 `chmod` 를 런타임에 우선 수행
    2. 애초에 gradlew 파일에 대한 실행 권한을 `chmod` 로 변경
        1. `git update-index --chmod=+x gradlew`
 
 ## REF
 [관련링크](https://stackoverflow.com/questions/33820638/travis-yml-gradlew-permission-denied/33820642)
 [travis job life cycle](https://docs.travis-ci.com/user/job-lifecycle/#the-job-lifecycle)
