import PropTypes from 'prop-types';
import { createContext, useContext, useState } from 'react';

const DailryContext = createContext();

export const DailryProvider = (props) => {
  const { children } = props;
  const [currentDailry, setCurrentDailry] = useState({
    dailryId: 3,
    pageId: 1,
    pageNumber: null,
  });

  return (
    <DailryContext.Provider value={{ currentDailry, setCurrentDailry }}>
      {children}
    </DailryContext.Provider>
  );
};

DailryProvider.propTypes = {
  children: PropTypes.node,
};

export const useDailryContext = () => {
  return useContext(DailryContext);
};
