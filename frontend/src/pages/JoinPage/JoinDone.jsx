import PropTypes from 'prop-types';
import * as S from '../LoginPage/LoginPage.styled';
import Button from '../../components/common/Button/Button';
import Text from '../../components/common/Text/Text';

const JoinDone = (props) => {
  const { nickname } = props;
  return (
    <S.LoginContainer>
      <Text size={24}>{nickname}님, 가입이 완료되었습니다!</Text>
      <Button onClick={() => alert('로그인 페이지로')}>로그인 페이지로</Button>
    </S.LoginContainer>
  );
};

JoinDone.propTypes = {
  nickname: PropTypes.string.isRequired,
};

export default JoinDone;
