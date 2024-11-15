import Todo from "Frontend/generated/dev/kavindupere/aitodoplanner/domain/Todo";
import { useEffect, useState } from "react";
import "../styles/styles.css";
import { TodoService } from "Frontend/generated/endpoints";
import { Grid, GridColumn, HorizontalLayout } from "@vaadin/react-components";
import TodoEditor from "Frontend/components/TodoEditor";

export default function TodosView() {
    const [todos, setTodos] = useState<Todo[]>([]);
    const [selected, setSelected] = useState<Todo | null>();

    useEffect(() => {
        TodoService.findAll().then(all => {
            setTodos(all);
            if (all.length) setSelected(all[0]);
        });
    }, []);

    async function onSubmit(todo: Todo) {
        const updated = await TodoService.save(todo);
        setTodos(todos.map(t => t.code === updated.code ? updated : t));
    }

    return (
        <div className="p-m">
            <h1>Todos</h1>

            <HorizontalLayout theme="spacing padding">
                <Grid
                    items={todos}
                    onActiveItemChanged={(e) => setSelected(e.detail.value)}
                    selectedItems={selected ? [selected] : []}
                >
                    <GridColumn path="code" />
                    <GridColumn path="title" />
                    <GridColumn path="description" />
                    <GridColumn path="completed" />
                </Grid>

                {selected && <TodoEditor todo={selected} onSubmit={onSubmit} />}
            </HorizontalLayout>

        </div>
    );
}
