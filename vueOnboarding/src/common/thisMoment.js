const dayOfWeek = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];

const getTimesOfTheDay = (hour) => {
  if (7 <= hour && hour < 12) return 'morning';
  else if (12 <= hour && hour < 18) return 'afternoon';
  else if (18 <= hour && hour < 22) return 'evening';
  else return 'night';
};

export const getThisIsTheMoment = () => {
  const today = new Date();

  return {
    timesOfTheDay: getTimesOfTheDay(today.getHours()),
    day: today.getDate(),
    weekday: dayOfWeek[today.getDay()].slice(0, 3),
    month: today.getMonth() + 1,
  };
};
