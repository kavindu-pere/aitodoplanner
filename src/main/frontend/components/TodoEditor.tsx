import Todo from "Frontend/generated/dev/kavindupere/aitodoplanner/domain/Todo";
import TodoModel from "Frontend/generated/dev/kavindupere/aitodoplanner/domain/TodoModel";
import { useForm } from "@vaadin/hilla-react-form";
import { Button, Checkbox, TextField } from "@vaadin/react-components";
import { useEffect } from "react";

interface TodoEditorProps {
    todo: Todo;
    onSubmit: (todo: Todo) => Promise<void>;
}

export default function TodoEditor({ todo, onSubmit }: TodoEditorProps) {
    const { field, model, submit, read } = useForm(TodoModel, { onSubmit });

    useEffect(() => {
        read(todo);
    }, [todo]);

    return (
        <div className="grid grid-cols-2 gap-s items-basline">
            <TextField label="Id" readonly {...field(model.code)} />
            <TextField label="Title" {...field(model.title)} />
            <TextField label="Description" {...field(model.description)} />
            <Checkbox label="Completed" {...field(model.completed)} />
            <Button onClick={submit}>Save</Button>
        </div>
    );
}
