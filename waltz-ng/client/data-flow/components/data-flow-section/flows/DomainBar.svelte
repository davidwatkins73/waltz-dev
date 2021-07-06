<script>
    export let width;
    export let x;
    export let item;
</script>

<g transform="translate(0 {item.y})"
   class:clickable={item.data.children}>
    <rect {x}
          {width}
          height={item.h}
          stroke="#ccc"
          fill="#fafafa"
          on:click>
    </rect>
    <text dy={item.h * 0.5 + 6 }
          style="pointer-events: none"
          text-anchor="middle">
        <tspan>{item.data.data.name}</tspan>
        <tspan>{item.data.children ? "+" : "-" }</tspan>
    </text>
    <circle fill="#f5dcda"
            cx={x + 10}
            r="4"
            cy={item.h / 2}>
    </circle>
</g>
