module.exports = [
  {
    url: '/user/info',
    type: 'get',
    response: (config) => {
      return {
        code: 200,
        data: {
          roles: ['admin'],
          introduction: 'I am a super administrator',
        },
      }
    },
  },
]
