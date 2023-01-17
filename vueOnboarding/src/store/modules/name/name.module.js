const state = {
  name: '',
};
const getters = {
  name(_state) {
    return _state.name;
  },
};
const mutations = {
  setName(_state, name) {
    _state.name = name
  }
}
const actions = {
  async saveName({ commit }, name) {
    commit('setName', name);
  }
}

export default {
  state,
  getters,
  actions,
  mutations,
};