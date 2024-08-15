<script>
export default {
  name: 'MenuItem',
  functional: true,
  props: {
    icon: {
      type: String,
      default: '',
    },
    elIcon: {
      type: String,
      default: '',
    },
    title: {
      type: String,
      default: '',
    },
  },
  render(h, context) {
    const { icon, title, elIcon } = context.props
    const vnodes = []

    if (icon) {
      vnodes.push(<svg-icon icon-class={icon} />)
    } else if (elIcon) {
      const eliconClass = `${elIcon} menu-el-icon`
      // 添加 element icon 支持
      vnodes.push(<i class={eliconClass} style="color: #fff" />)
    }

    if (title) {
      if (title.length > 5) {
        vnodes.push(
          <span slot="title" title={title}>
            {title}
          </span>,
        )
      } else {
        vnodes.push(<span slot="title">{title}</span>)
      }
    }
    return vnodes
  },
}
</script>
